package api.models.args.projects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProject {
    private String name;
    private String description;
    private int owner_id;
//    private String identifier;
//    private String start_date;
//    private String end_date;

}