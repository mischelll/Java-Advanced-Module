package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> departmentPatients = new LinkedHashMap<>();
        Map<String, List<String>> departmentDoctor = new LinkedHashMap<>();

        String command = "";
        while (!"Output".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String department = data[0];
            String doctorFname = data[1];
            String doctorSname = data[2];
            String patient = data[3];
            String doctor = doctorFname + doctorSname;

            if (department.length() < 1 || department.length() >= 100) {
                continue;
            } else if (doctorFname.length() < 1 || doctorFname.length() >= 20) {
                continue;
            } else if (doctorSname.length() < 1 || doctorSname.length() >= 20) {
                continue;
            } else if (patient.length() < 1 || patient.length() >= 20) {
                continue;
            }


            departmentPatients.putIfAbsent(department, new LinkedList<>());
            if (departmentPatients.get(department).size() < 60) {
                departmentPatients.get(department).add(patient);
            }

            departmentDoctor.putIfAbsent(doctor, new LinkedList<>());
            departmentDoctor.get(doctor).add(patient);
        }

        String input = "";
        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");


            if (data.length == 2) {
                if (Character.isDigit(data[1].charAt(0))) {
                    String department2 = data[0];
                    if (departmentPatients.containsKey(department2)) {
                        int room = Integer.parseInt(data[1]);
                        if (room > 20 || room < 0) {
                            continue;
                        }
                        int numOfPatients = (room - 1) * 3;
                        Set<String> patiensOfRoom = new TreeSet<>();
                        for (int i = numOfPatients; i < numOfPatients + 3; i++) {
                            patiensOfRoom.add(departmentPatients.get(data[0]).get(i));
                        }
                        patiensOfRoom.forEach(System.out::println);
                    }
                } else {
                    String doctroFullName = data[0] + data[1];
                    if (departmentDoctor.containsKey(doctroFullName)) {

                        departmentDoctor.get(doctroFullName)
                                .stream()
                                .sorted(String::compareTo)
                                .forEach(System.out::println);
                    }
                }
            } else {
                if (departmentPatients.containsKey(data[0])) {

                    departmentPatients.get(data[0]).forEach(System.out::println);
                }
            }
        }
    }


}



