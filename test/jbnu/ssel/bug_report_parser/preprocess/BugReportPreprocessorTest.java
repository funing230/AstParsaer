package jbnu.ssel.bug_report_parser.preprocess;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import io.kuy.infozilla.elements.stacktrace.java.StackTrace;

public class BugReportPreprocessorTest {
	public static void main(String[] args) {
		BugReportPreprocessor brp = new BugReportPreprocessor();
		HashMap<String, List<StackTrace>> stackTracesMap = brp.getStacktraces("RHQ Project");
		for ( Entry<String, List<StackTrace>> bugReport : stackTracesMap.entrySet()) {
			System.out.println("BugReport ID: " + bugReport.getKey()+"\n");
			List<StackTrace> stackTraces = bugReport.getValue();
			for (StackTrace stackTrace : stackTraces) {
				System.out.println("Exception:" + stackTrace.getException()+"\n");
				System.out.println("Reason:" + stackTrace.getReason()+"\n");
				List<String> frames = stackTrace.getFrames();
				System.out.println(frames.size()+"\n");
			}
		}
	}
}
