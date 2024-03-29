package com.example.demo.Tables;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Embeddable//if you want this class table to have access to another table use this
//and have the object of this class in field of that class for example in student class
/** and use @Embedded fot that object to inform spring that is embedded*/
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",//the column of this class
                column = @Column(name = "guardian_name")//the real name of that class that shows in table in dbeaver
        ),
        @AttributeOverride(
                name = "email",//the column of this class
                column = @Column(name = "guardian_email")//the real name of that class that shows in table in dbeaver
        ),
        @AttributeOverride(
                name = "mobile",//the column of this class
                column = @Column(name = "guardian_mobile")//the real name of that class that shows in table in dbeaver
        )

}
)
public class Guardian {
    /**     be careful becuase of jpa repository you should have kamel format for you filed name if not you get
     * exception from jpa repository*/
    private String name;
    private String email;
    private String mobile;
}
