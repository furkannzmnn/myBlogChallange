package com.example.myblog.dto.converter;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogSaveRequestConverter {

    public Blog blogSaveRequestToBlog(BlogSaveRequest request){

        return new Blog(request.getContent(),
                        request.getAuthor());

    }
}
