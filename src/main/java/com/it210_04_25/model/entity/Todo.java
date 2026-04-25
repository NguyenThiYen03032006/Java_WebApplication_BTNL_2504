package com.it210_04_25.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Noi dung khong duoc de trong")
    private String content;

    @FutureOrPresent(message = "Ngay phai o hien tai hoac tuong lai")
    private LocalDate dueDate;

    private String status;
    private String priority;
}
