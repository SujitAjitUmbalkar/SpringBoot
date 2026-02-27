package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.services;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.entities.PostEnity;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService
{
     private final PostRepository postRepository;
     private final ModelMapper modelMapper;


    @Override
    public List<PostDTO> getAllPosts()
    {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost)
    {
        PostEnity postEntity = modelMapper.map(inputPost, PostEnity.class);     // covnert in ENtity
//        PostEnity savedPost =  postRepository.save(postEntity);         // save entity
//        return modelMapper.map(savedPost , PostDTO.class);

      return modelMapper.map(postRepository.save(postEntity) , PostDTO.class );
    }

    @Override
    public PostDTO getPostById(Long postId)
    {
        PostEnity foundEntity = postRepository.
                findById(postId).
                orElseThrow( () -> new ResourceNotFoundException("Post not found with id" + postId) );

        return modelMapper.map(foundEntity, PostDTO.class);

//         return modelMapper.map(postRepository.findById(postId) , PostDTO.class ) ;
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId)
    {
        PostEnity olderPost = postRepository.
            findById(postId).
            orElseThrow( () -> new ResourceNotFoundException("Post not found with id" + postId) );

        inputPost.setId(postId);
         modelMapper.map(inputPost,olderPost);

       PostEnity savedEntity =   postRepository.save(olderPost);
         return modelMapper.map(inputPost , PostDTO.class);

    }

}
