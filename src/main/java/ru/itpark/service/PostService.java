package ru.itpark.service;

import ru.itpark.domain.Post;
import ru.itpark.repository.PostRepository;

public class PostService {
    private PostRepository repository;
    private int nextId = 1;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public void create(String name, String[] tags) {
        Post post = new Post(nextId, name, tags);
        repository.add(post);
        nextId++;
    }

    public Post[] search(String text) {
        if (text.startsWith("#")) {
            String tag = text.substring(1); // "отрезаем" символ решётки
            return searchByTag(tag); // "делегируем"
        }

        return searchByName(text);
    }

    public Post[] searchByName(String name) {
        Post[] result = new Post[10];
        int resultIndex = 0;

        Post[] posts = repository.getAll();
        for (Post post : posts) { // posts - массив, post - конкретный элемент из этого массива
            if (post == null) {
                continue;
            }

            if (!post.getName().contains(name)) {
                continue;
            }

            result[resultIndex] = post;
            resultIndex++;
        }

        return result;
    }

    public Post[] searchByTag(String text) {
        Post[] result = new Post[10];
        int resultIndex = 0;

        Post[] posts = repository.getAll();
        for (Post post : posts) { // posts - массив, post - конкретный элемент из этого массива
            if (post == null) {
                continue;
            }

            // TODO:
            String[] tags = post.getTags();
            for (String tag : tags) { // перебираем все теги поста
                if (tag.equals(text)) { // если тег соответствует
                    result[resultIndex] = post; // кладём пост в результаты поиска
                    resultIndex++;
                    break; // следующие теги перебирать смысла нет (т.к. наш уже подошёл)
                }
            }
        }

        return result;
    }
}
