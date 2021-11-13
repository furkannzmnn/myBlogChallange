package com.example.myblog.service;

import com.example.myblog.dto.AuthorDto;
import com.example.myblog.dto.BlogDto;
import com.example.myblog.dto.converter.AuthorSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.AuthorDtoConverter;
import com.example.myblog.dto.request.AuthorSaveRequest;
import com.example.myblog.model.Author;
import com.example.myblog.model.Blog;
import com.example.myblog.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {

    private AuthorRepository authorRepository;
    private AuthorSaveRequestConverter authorSaveRequestConverter;
    private AuthorDtoConverter authorDtoConverter;
    private AuthorService authorService;
    @BeforeEach
    public void setUp() throws Exception {
        authorRepository = mock(AuthorRepository.class);
        authorSaveRequestConverter = mock(AuthorSaveRequestConverter.class);
        authorDtoConverter = mock(AuthorDtoConverter.class);
        authorService = new AuthorService(authorRepository,authorSaveRequestConverter,authorDtoConverter);
    }

    @Test
    public void createAuthor() {
        //given
        Author author = new Author("FURKAN OZMEN");
        AuthorDto actual = new AuthorDto(12,author.getAuthorFullName());
        AuthorSaveRequest request = new AuthorSaveRequest(author.getAuthorFullName());

        //when
        when(authorDtoConverter.convertToAuthorDto(authorRepository.save(author))).thenReturn(actual);
        when(authorSaveRequestConverter.authorSaveRequestToAuthor(request)).thenReturn(author);

        //then
        AuthorDto expected = authorService.createAuthor(request);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void authorList() {

        Author author = new Author("FURKAN ÖZMEN");
        AuthorDto actual = new AuthorDto(12,author.getAuthorFullName());

        Mockito.when(authorRepository.findAll()).thenReturn(List.of(author));
        Mockito.when(authorDtoConverter.convertToAuthorDto(author)).thenReturn(actual);

        List<AuthorDto> result = authorService.authorList();
        assertEquals(result ,List.of(actual));
    }
}