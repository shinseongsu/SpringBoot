package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.posts.PostRepository;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.web.dto.PostsListResponseeDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException(
                            "해당 사용자가 없습니다. id = " + id
                    ));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseeDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
                    .map(PostsListResponseeDto::new)
                    .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        postRepository.delete(posts);
    }

}
