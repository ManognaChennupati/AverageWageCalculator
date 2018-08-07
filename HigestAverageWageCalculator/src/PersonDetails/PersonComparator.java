package PersonDetails;


import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return new CompareToBuilder()
        		.append(p2.getRate(),p1.getRate())
                .append(p1.getDepartment(), p2.getDepartment())
                .append(p1.getJobTitle(), p2.getJobTitle())
                .toComparison();
    }

}
