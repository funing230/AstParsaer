package jbnu.ssel.bug_report_parser.preprocess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import b4j.core.Issue;
import b4j.core.LongDescription;
import io.kuy.infozilla.elements.stacktrace.java.StackTrace;
import io.kuy.infozilla.filters.FilterChainEclipse;
import jbnu.ssel.bug_report_parser.preprocess.bugzilla.BugZillaSession;

public class BugReportPreprocessor {

	private boolean withStackTraces = true;

	private boolean withPatches = true;

	private boolean withCode = true;

	private boolean withLists = true;

	private String inputCharset = "ISO-8859-1";

	private File[] inputFiles;

	private BugZillaSession bzs;

	public BugReportPreprocessor() {
		bzs = new BugZillaSession();
		bzs.newInitSession();// TODO Auto-generated constructor stub
	}

	public HashMap<String, List<StackTrace>> getStacktraces(String projectName) {
		HashMap<String, List<StackTrace>> stackTraceHashMap = new HashMap<String, List<StackTrace>>();
		Iterator<Issue> issues = bzs.newSearchBugs("RHQ Project");
		while (issues.hasNext()) {
			
			
			Issue issue = (Issue) issues.next();
			String bugReportID = issue.getId();
			Iterator<LongDescription> longDescriptions = issue.getLongDescriptionIterator();
			while (longDescriptions.hasNext()) {
				LongDescription longDescription = (LongDescription) longDescriptions.next();
				String description = longDescription.getTheText();
				// Run infozilla
				FilterChainEclipse infozilla_filters = new FilterChainEclipse(description, withPatches, withStackTraces,
						withCode, withLists);
				List<StackTrace> stacktraces = infozilla_filters.getTraces();
				if(stacktraces.size()>0)
					stackTraceHashMap.put(bugReportID, stacktraces);
			}
		}
		bzs.closeSession();
		return stackTraceHashMap;
	}
}
