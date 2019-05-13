package ru.itpark.repository;

import ru.itpark.domain.Post;

public class PostRepository {
    private Post[] posts = new Post[50];
    private int nextIndex = 0;

    public void add(Post post) {
        posts[nextIndex] = post;
        nextIndex++;
    }

    public Post[] getAll() {
        return posts;
    }
}
