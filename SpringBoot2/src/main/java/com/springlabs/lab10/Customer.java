package com.springlabs.lab10;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
public class Customer {

    @NotBlank(message = "{name.required}")
    @Size(min = 2, max = 30, message = "{name.size}")
    private String name;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotNull(message = "{age.required}")
    private Integer age;

    @NotNull(message = "{gender.required}")
    private String gender;

    @Past(message = "{birthday.past}")
    @NotNull(message = "{birthday.required}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Pattern(regexp = "^\\d{10}$|^(\\d{3}-\\d{3}-\\d{4})$|^\\d{10}x\\d{4}$", message = "{phone.invalid}")
    private String phone;
}