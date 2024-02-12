package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") // нейминг в базе данных
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType; // расширение файла
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage; // флажок превьюшная фотография
    @Lob // в базе переменная будет в типе LongBLob
    @Column(name = "bytes")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) // установка отношения ФОТО к ТОВАРУ (Hibernate) # EAGER - для быстрой загрузки
    private Product product;

}
