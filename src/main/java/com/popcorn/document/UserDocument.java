package com.popcorn.document;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(value = "users")
public class UserDocument {
    @PrimaryKeyColumn(name = "country", type = PrimaryKeyType.PARTITIONED)
    private String country;

    @PrimaryKeyColumn(name = "lname", type = PrimaryKeyType.CLUSTERED)
    private String lastName;

//    @Column(value = "uid")
//    private UUID uid;

    @Column(value = "fname")
    private String firstName;

    private String email;
}
