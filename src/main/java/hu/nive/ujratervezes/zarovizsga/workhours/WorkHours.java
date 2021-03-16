package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkHours {

    public String minWork(String filePath) {

        try (BufferedReader br = Files.newBufferedReader(Path.of(filePath))) {

            List<Work> works = new ArrayList<>();
            readLines(br, works);
            sortWorks(works);
            return works.get(0).toString();

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

    public void readLines(BufferedReader reader, List<Work> works) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {

            String[] temp = line.split(",");
            String name = temp[0];
            int workHours = Integer.parseInt(temp[1]);
            LocalDate workDay = LocalDate.parse(temp[2]);

            works.add(new Work(
                    name, workHours, workDay
            ));
        }
    }

    public void sortWorks(List<Work> works) {
        works.sort(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.getWorkHours()- o2.getWorkHours();
            }
        });
    }
}
