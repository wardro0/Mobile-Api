package com.ipkras.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ipkras.controller.insertToGlocalTables;

/**
 * Servlet implementation class PostConsultation
 */
@WebServlet("/postconsultation")
public class PostConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostConsultation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doPost(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
			String replymsg = "";
			response.getWriter().append("{ \"message\": \"Posting Failed\", \"success\": false }");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			String authKey = "Basic : 6534ac31-ad41-4884-a10f-db77bf3ae22";
			String headerauth = request.getHeader("Authorization");
			if(authKey.equals(headerauth)) {
				System.out.println("Header: "+headerauth);
				
				String testBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
				
				String str = testBody;
				
				JSONObject obj = new JSONObject(str);
				String philhealthId = obj.getString("philhealthId");
				JSONArray arr1 = obj.getJSONArray("symptomList");
				ArrayList<String> symptoms = new ArrayList<String>();
				insertToGlocalTables igt = new insertToGlocalTables();
				
				for (int i = 0; i < arr1.length(); i++) {
					JSONObject jsonobject = arr1.getJSONObject(i);
				    symptoms.add(jsonobject.getString("symptompName"));
				    symptoms.add(jsonobject.getString("severity"));
				    symptoms.add(jsonobject.getString("since"));
				    igt.insertSymptoms(philhealthId, jsonobject.getString("symptompName"), jsonobject.getString("severity"),
				    		jsonobject.getString("since"));
				}
				
				JSONArray arr2 = obj.getJSONArray("diseasesList");
				ArrayList<String> diseases = new ArrayList<String>();
				for (int i = 0; i < arr2.length(); i++) {
					JSONObject jsonobject = arr2.getJSONObject(i);
					diseases.add(jsonobject.getString("diseaseName"));
					diseases.add(jsonobject.getString("natureOfDiagnosis"));
					igt.insertDiseases(philhealthId, jsonobject.getString("diseaseName"), 
							jsonobject.getString("natureOfDiagnosis"));
				}
				
				String reviewdate = obj.getString("reviewDate");
				
				JSONArray arr3 = obj.getJSONArray("riskfactorList");
				ArrayList<String> riskfactors = new ArrayList<String>();
				for (int i = 0; i < arr3.length(); i++) {
					JSONObject jsonobject = arr3.getJSONObject(i);
					riskfactors.add(jsonobject.getString("riskfactorName"));
					riskfactors.add(jsonobject.getString("riskfactorSince"));
					igt.insertRisks(philhealthId, jsonobject.getString("riskfactorName"), 
							jsonobject.getString("riskfactorSince"));
				}
				
				JSONArray arr4 = obj.getJSONArray("testList");
				ArrayList<String> testlist = new ArrayList<String>();
				for (int i = 0; i < arr4.length(); i++) {
					JSONObject jsonobject = arr4.getJSONObject(i);
					testlist.add(jsonobject.getString("investigationName"));
					igt.insertTests(philhealthId, jsonobject.getString("investigationName"));
				}	 
				
				JSONArray arr5 = obj.getJSONArray("procedureList");
				ArrayList<String> procedurelist = new ArrayList<String>();
				for (int i = 0; i < arr5.length(); i++) {
					JSONObject jsonobject = arr5.getJSONObject(i);
					procedurelist.add(jsonobject.getString("procedureName"));
					procedurelist.add(jsonobject.getString("planDate"));
					igt.insertProcedures(philhealthId, jsonobject.getString("procedureName"), 
							jsonobject.getString("planDate"));
				}	
				
				JSONArray arr6 = obj.getJSONArray("medicineList");
				ArrayList<String> medicinelist = new ArrayList<String>();
				for (int i = 0; i < arr6.length(); i++) {
					JSONObject jsonobject = arr6.getJSONObject(i);
					medicinelist.add(jsonobject.getString("dosage"));
					medicinelist.add(jsonobject.getString("itemName"));
					medicinelist.add(jsonobject.getString("frequency"));
					medicinelist.add(jsonobject.getString("duration"));
					medicinelist.add(jsonobject.getString("notes"));
					medicinelist.add(jsonobject.getString("genericName"));
					medicinelist.add(jsonobject.getString("timing"));
					igt.insertMedicines(philhealthId, jsonobject.getString("dosage"), jsonobject.getString("itemName"), 
							jsonobject.getString("frequency"), jsonobject.getString("duration"), 
							jsonobject.getString("notes"), jsonobject.getString("genericName"), 
							jsonobject.getString("timing"));
				}	
				
				String diastolicBP = obj.getInt("diastolicBP") + "";
				String systolicBP = obj.getInt("systolicBP") + "";
				String pulse = obj.getInt("pulse") + "";
				String respiration = obj.getInt("respiration") + "";
				String temperature = obj.getInt("temperature") + "";
				String weight = obj.getInt("weight") + "";
				String height = obj.getInt("height") + "";
				String oxyzenSaturation = obj.getInt("oxyzenSaturation") + "";
				String note = obj.getString("note");
				
				JSONArray arr7 = obj.getJSONArray("phaysicalExamList");
				ArrayList<String> phaysicalexamlist = new ArrayList<String>();
				for (int i = 0; i < arr7.length(); i++) {
					JSONObject jsonobject = arr7.getJSONObject(i);
					phaysicalexamlist.add(jsonobject.getString("phayExamName"));
					igt.insertPhysicalExam(philhealthId, jsonobject.getString("phayExamName"));
				}	
				
				String dietType = obj.getString("dietType");			
				
				JSONArray arr8 = obj.getJSONArray("parametersForMonitor");
				ArrayList<String> parametersformonitor = new ArrayList<String>();
				for (int i = 0; i < arr8.length(); i++) {
					parametersformonitor.add(arr8.getString(i));
					igt.insertParameters(philhealthId, arr8.getString(i));
				}
				
				String tempUnit = obj.getString("tempUnit");
				String heightUnit = obj.getString("heightUnit");
				String referByDoctor = obj.getString("referByDoctor");
				String lmp = obj.getString("lmp");
				String refer = obj.getString("refer");
				String referDocName = obj.getString("referDocName");
				String medicalNotes = obj.getString("medicalNotes");
				
				igt.insertVitals(philhealthId, diastolicBP, systolicBP, 
						pulse, respiration, temperature, 
						weight, height, oxyzenSaturation,
						note, dietType);
				
				igt.insertConsult(philhealthId, tempUnit, heightUnit, 
						referByDoctor, referDocName, medicalNotes, lmp, refer);
							
				response.getWriter().append("{ \"message\": \"Successfully Processed\", \"success\": true }");
			}else {
				response.getWriter().append("{ \"message\": \"Authentication Failed\", \"success\": false }");
			}
	    } catch (Exception e) {
	      e.printStackTrace();
	      response.getWriter().append("{ \"message\": \"Processing Failed\", \"success\": false }");
	    }
	}

}
