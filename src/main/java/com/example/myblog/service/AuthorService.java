package com.example.myblog.service;

import com.example.myblog.dto.AuthorDto;
import com.example.myblog.dto.Constant;
import com.example.myblog.dto.converter.AuthorSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.AuthorDtoConverter;
import com.example.myblog.dto.request.AuthorSaveRequest;
import com.example.myblog.model.Author;
import com.example.myblog.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.SystemException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorSaveRequestConverter authorSaveRequestConverter;
    private final AuthorDtoConverter authorDtoConverter;

    public AuthorService(AuthorRepository authorRepository, AuthorSaveRequestConverter authorSaveRequestConverter, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorSaveRequestConverter = authorSaveRequestConverter;
        this.authorDtoConverter = authorDtoConverter;
    }

    public AuthorDto createAuthor(AuthorSaveRequest authorSaveRequest){

        Author author = authorSaveRequestConverter.authorSaveRequestToAuthor(authorSaveRequest);

        return authorDtoConverter.convertToAuthorDto(
                this.authorRepository.save(author)
        );
    }

    public List<AuthorDto> authorList(){
        return this.authorRepository.findAll()
                .stream()
                .map(authorDtoConverter::convertToAuthorDto)
                .collect(Collectors.toList());
    }

    public Author findById(int id){
        return this.authorRepository.findById(id).orElseThrow(()->new RuntimeException(Constant.AUTHOR_NOT_FOUND.toString()));
    }
}
