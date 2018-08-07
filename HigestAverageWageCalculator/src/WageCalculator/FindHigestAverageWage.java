package WageCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import PersonDetails.Person;

public class FindHigestAverageWage {

	public static void main(String args[]) throws IOException {

		List<Person> list = readCvsFile();
		Map<String, List<Person>> personInfobyFirstName = addPersonsInfoToMap(list);
		for (String personfirstName : personInfobyFirstName.keySet()) {
			List<Person> personsList = personInfobyFirstName.get(personfirstName);
			double rate1 = 0.0;
			double averagerate = 0.0;
			String[] jobtitles = personsList.get(0).getJobTitle().split(",");
			String jobtitle = jobtitles[0];
			String Department = personsList.get(0).getDepartment();
			for (int i = 0; i < personsList.size(); i++) {
				rate1 = rate1 + personsList.get(i).getRate();
			}
			averagerate = (rate1 / personsList.size());
			displayJson(averagerate, jobtitle, Department, personfirstName);
		}
	}

	private static Map<String, List<Person>> addPersonsInfoToMap(List<Person> list) {
		Map<String, List<Person>> usersByName = new HashMap<String, List<Person>>();
		for (Person personInfo : list) {
			if (usersByName.containsKey(personInfo.getFirstName())) {
				usersByName.get(personInfo.getFirstName()).add(personInfo);

			} else {
				List<Person> users = new ArrayList<Person>(1);
				users.add(personInfo);
				usersByName.put(personInfo.getFirstName(), users);
			}
		}
		return usersByName;
	}

	private static List<Person> readCvsFile() throws IOException {
		BufferedReader reader = Files.newBufferedReader(Paths.get("City_of_Seattle_Wage_Data.csv"));
		reader.readLine();
		List<Person> list = new ArrayList<Person>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			Person person = new Person();
			String Department = csvRecord.get(0);
			String LastName = csvRecord.get(1);
			String FirstName = csvRecord.get(2);
			String JobTitle = csvRecord.get(3);
			String Rate = csvRecord.get(4);
			person.setJobTitle(JobTitle);
			person.setDepartment(Department);
			person.setLastName(LastName);
			person.setFirstName(FirstName);
			person.setRate(Double.parseDouble(Rate));
			list.add(person);
		}
		return list;
	}

	static void displayJson(double avgRate, String JobTitle, String Department, String FirstName) {
		System.out.println("{ \"" + FirstName + "\": { \"Department\": \"" + Department + "\", \"Job Title\": \""
				+ JobTitle + "\", \"Average Hourly Rate\": \"" + avgRate + "\" } }");
	}

}
