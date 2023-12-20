package com.ipkras.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.ipkras.dao.ConnectionFactory;

public class insertToGlocalTables {

	private static String INSERT_GLOCAL_DISEASES = "INSERT INTO glocal_diseases(philhealth_id,diseaseName,natureofDiagnosis)"
    		+ " VALUES('@1@','@2@','@3@')";
	
	private static String INSERT_GLOCAL_MEDICINES = "INSERT INTO glocal_medicines(philhealth_id, dosage, itemname, "
			+ "frequency, duration, notes, genericname, timing)"
    		+ " VALUES('@1@','@2@','@3@','@4@','@5@','@6@','@7@','@8@')";
	
	private static String INSERT_GLOCAL_PARAMETERS = "INSERT INTO glocal_parameters(philhealth_id, paramsformonitor)"
    		+ " VALUES('@1@','@2@')";
	
	private static String INSERT_GLOCAL_PHYSEXAM = "INSERT INTO glocal_physicalexam(philhealth_id, physexamname)"
    		+ " VALUES('@1@','@2@')";
	
	private static String INSERT_GLOCAL_PROCEDURES = "INSERT INTO glocal_procedures(philhealthid, procedureName, "
			+ "planDate)"
    		+ " VALUES('@1@','@2@','@3@')";
	
	private static String INSERT_GLOCAL_RISKS = "INSERT INTO glocal_risks(philhealth_id, "
			+ "riskfactorName, riskfactorSince)"
    		+ " VALUES('@1@','@2@','@3@')";
	
	private static String INSERT_GLOCAL_SYMPTOMS = "INSERT INTO glocal_symptoms(philhealth_id, "
			+ "symptomname, since, severity)"
    		+ " VALUES('@1@','@2@','@3@','@4@')";
	
	private static String INSERT_GLOCAL_TESTS = "INSERT INTO glocal_tests(philhealth_id, investigationName)"
    		+ " VALUES('@1@','@2@')";
	
	private static String INSERT_GLOCAL_VITALS = "INSERT INTO glocal_vitals(philhealth_id, "
			+ "diastolicbp, systolicbp, pulse, respiration, temperature, weight, height, oxygensaturation, notes, "
			+ "diettype)"
    		+ " VALUES('@1@','@2@','@3@','@4@','@5@','@6@','@7@','@8@','@9@','@10@','@11@')";
	
	private static String INSERT_GLOCAL_CONSULT = "INSERT INTO glocal_consult(philhealth_id, tempunit, heightunit, "
			+ "referbydoctor, "
			+ "referdocname, medicalnotes, lmp, refer)"
    		+ " VALUES('@1@','@2@','@3@','@4@','@5@','@6@','@7@','@8@')";
	
	public void insertDiseases(String philhealthid,String diseaseName, String natureofDiagnosis) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_DISEASES;
			
			query = query.replaceAll("@1@", philhealthid);
			query = query.replaceAll("@2@", diseaseName);
			query = query.replaceAll("@3@", natureofDiagnosis);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

	public void insertMedicines(String philhealth_id, String dosage, String itemname, 
			String frequency, String duration, String notes, String genericname, String timing) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_MEDICINES;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", dosage);
			query = query.replaceAll("@3@", itemname);
			query = query.replaceAll("@4@", frequency);
			query = query.replaceAll("@5@", duration);
			query = query.replaceAll("@6@", notes);
			query = query.replaceAll("@7@", genericname);
			query = query.replaceAll("@8@", timing);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertParameters(String philhealth_id, String paramsformonitor) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_PARAMETERS;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", paramsformonitor);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertPhysicalExam(String philhealth_id, String physexamname) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_PHYSEXAM;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", physexamname);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertProcedures(String philhealthid, String procedureName, String planDate) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_PROCEDURES;
			
			query = query.replaceAll("@1@", philhealthid);
			query = query.replaceAll("@2@", procedureName);
			query = query.replaceAll("@3@", planDate);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertRisks(String philhealth_id, String riskfactorName, String riskfactorSince) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_RISKS;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", riskfactorName);
			query = query.replaceAll("@3@", riskfactorSince);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertSymptoms(String philhealth_id, String symptomname, String since, String severity) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_SYMPTOMS;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", symptomname);
			query = query.replaceAll("@3@", since);
			query = query.replaceAll("@4@", severity);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertTests(String philhealth_id, String investigationName) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_TESTS;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", investigationName);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertVitals(String philhealth_id, 
			String diastolicbp, String systolicbp, String pulse, String respiration, String temperature, 
			String weight, String height, String oxygensaturation, String notes, String diettype) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_VITALS;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", diastolicbp);
			query = query.replaceAll("@3@", systolicbp);
			query = query.replaceAll("@4@", pulse);
			query = query.replaceAll("@5@", respiration);
			query = query.replaceAll("@6@", temperature);
			query = query.replaceAll("@7@", weight);
			query = query.replaceAll("@8@", height);
			query = query.replaceAll("@9@", oxygensaturation);
			query = query.replaceAll("@10@", notes);
			query = query.replaceAll("@11@", diettype);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void insertConsult(String philhealth_id, String tempunit, String heightunit, 
			String referbydoctor, String referdocname, 
			String medicalnotes, String lmp, String refer) {
		try {
	        Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
						
			String query = INSERT_GLOCAL_CONSULT;
			
			query = query.replaceAll("@1@", philhealth_id);
			query = query.replaceAll("@2@", tempunit);
			query = query.replaceAll("@3@", heightunit);
			query = query.replaceAll("@4@", referbydoctor);
			query = query.replaceAll("@5@", referdocname);
			query = query.replaceAll("@6@", medicalnotes);
			query = query.replaceAll("@7@", lmp);
			query = query.replaceAll("@8@", refer);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			
			st.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
