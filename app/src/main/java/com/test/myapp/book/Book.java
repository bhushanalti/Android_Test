package com.test.myapp.book;

import java.util.HashMap;
import java.util.Map;

public class Book {

        private String id;

        private String isbn;

        private String title;

        private String author;

        private String publisher;

        private String image;

        private Integer v;

        private Map<String, Object> additionalProperties = new HashMap<String, Object>();


        public String getId() {
            return id;
        }


        public void setId(String id) {
            this.id = id;
        }


        public String getIsbn() {
            return isbn;
        }


        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }


        public String getTitle() {
            return title;
        }


        public void setTitle(String title) {
            this.title = title;
        }


        public String getAuthor() {
            return author;
        }


        public void setAuthor(String author) {
            this.author = author;
        }


        public String getPublisher() {
            return publisher;
        }


        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }


        public String getImage() {
            return image;
        }


        public void setImage(String image) {
            this.image = image;
        }


        public Integer getV() {
            return v;
        }


        public void setV(Integer v) {
            this.v = v;
        }


        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }


        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
}
