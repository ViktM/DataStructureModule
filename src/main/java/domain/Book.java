package domain;

import java.util.Objects;

public class Book {
    private String author;
    private String country;
    private String imageLink;
    private String language;
    private String link;
    private int pages;
    private String title;
    private int year;

    public Book() {
    }

    public Book(
            String author,
            String country,
            String imageLink,
            String language,
            String link,
            int pages,
            String title,
            int year
    ) {
        this.author = author;
        this.country = country;
        this.imageLink = imageLink;
        this.language = language;
        this.link = link;
        this.pages = pages;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getCountry() {
        return country;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLanguage() {
        return language;
    }

    public String getLink() {
        return link;
    }

    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", country='" + country + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", language='" + language + '\'' +
                ", link='" + link + '\'' +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                year == book.year &&
                Objects.equals(author, book.author) &&
                Objects.equals(country, book.country) &&
                Objects.equals(imageLink, book.imageLink) &&
                Objects.equals(language, book.language) &&
                Objects.equals(link, book.link) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, country, imageLink, language, link, pages, title, year);
    }
}
