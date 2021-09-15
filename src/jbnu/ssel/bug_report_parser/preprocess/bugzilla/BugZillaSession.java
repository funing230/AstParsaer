package jbnu.ssel.bug_report_parser.preprocess.bugzilla;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import b4j.core.DefaultIssue;
import b4j.core.DefaultSearchData;
import b4j.core.Issue;
import b4j.core.session.AuthorizationCallback;
import b4j.core.session.HttpBugzillaSession;
import b4j.core.session.SimpleAuthorizationCallback;

public class BugZillaSession {

	private HttpBugzillaSession session;


	public void newInitSession() {
		try {
			// Create the session
			session = new HttpBugzillaSession();
			session.setBaseUrl(new URL(jbnu.ssel.bug_report_parser.util.Configuration.BUGZILLA_URL));
			session.setBugzillaBugClass(DefaultIssue.class);
			AuthorizationCallback authCallback = new SimpleAuthorizationCallback(
					jbnu.ssel.bug_report_parser.util.Configuration.BUGZILLA_ID, jbnu.ssel.bug_report_parser.util.Configuration.BUGZILLA_PW);
			session.setAuthorizationCallback(authCallback);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
	}

	public Iterator<Issue> newSearchBugs(String bugID) {
		Iterator<Issue> issues= null;
		// Open the session
		if (session.open()) {
			// Search a bug
			DefaultSearchData searchData = new DefaultSearchData();
			searchData.add("bug_id", bugID);

			// Perform the search
			issues = session.searchBugs(searchData, null);
			return issues;
			// Close the session
		}
		return issues;
	}

	
	public void closeSession() {
		session.close();
	}
}
