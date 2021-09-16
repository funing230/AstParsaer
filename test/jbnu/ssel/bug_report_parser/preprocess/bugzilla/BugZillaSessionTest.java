package jbnu.ssel.bug_report_parser.preprocess.bugzilla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import b4j.core.Issue;
import b4j.core.LongDescription;

import funing.excel.ExcelWriter;
import funing.excel.bug_id_s;

public class BugZillaSessionTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		
		BugZillaSession bzs = new BugZillaSession();
		bzs.newInitSession();
		
//funing__________________________________________________________________________________________	
		
				
		ExcelWriter ew =new ExcelWriter();
		
		ArrayList<Integer> bug_id= ew.get_bugid();
		
		ArrayList<bug_id_s> bug_id_s=new ArrayList();
		
		//int i=0;
		
		for(int bugid : bug_id) {
			
			//i++;111
			
			Iterator<Issue> issues = bzs.newSearchBugs(bugid+"");
			String severity=null;
			while (issues.hasNext()) {
				Issue issue = (Issue) issues.next();
				severity = issue.getSeverity();
				bug_id_s.add(new bug_id_s(bugid+"",severity));						
			}
			System.out.println(bugid+" "+severity);	
			
			//if(i==20) break;
		}
		
//funing__________________________________________________________________________________________		
		bzs.closeSession();
		
		ew.Write_Serverity_id_s(bug_id_s);
	}
}

//Iterator<Issue> issues = bzs.newSearchBugs("384108");
//while (issues.hasNext()) {
//	Issue issue = (Issue) issues.next();
//	String severity = issue.getSeverity();
//	System.out.println("----------------------------------");
//	System.out.println("Severity: " + severity);
//	Iterator<LongDescription> longDescriptions = issue.getLongDescriptionIterator();
//	while (longDescriptions.hasNext()) {
//		LongDescription longDescription = (LongDescription) longDescriptions.next();
//		System.out.println("----------------------------------");
//		System.out.println(longDescription.getTheText());
//	}
//}



//ExcelWriter ew =new ExcelWriter();
//
//ArrayList<Integer> bug_id= ew.get_bugid();
//
//ArrayList<String> servity_list=new ArrayList();
//
//for(int bugid : bug_id) {
//	
//	Iterator<Issue> issues = bzs.newSearchBugs(bugid+"");
//	String severity=null;
//	while (issues.hasNext()) {
//		Issue issue = (Issue) issues.next();
//		severity = issue.getSeverity();
//		servity_list.add(severity);						
//	}
//	System.out.println(bugid+""+severity);			
//}

