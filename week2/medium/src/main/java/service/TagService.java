package service;

import dao.TagDao;
import model.Tag;
import model.User;

import java.util.List;

public class TagService {
    private TagDao tagDao = new TagDao();

    public void createTag(Tag tag){
        tagDao.saveTag(tag);
        System.out.println("createTag::" + tag.getTitle());
    }

    public List<Tag> getAll(){
        return tagDao.findAll();
    }
    public  void printAllTag(){ //bütün userları getiren metod
        getAll().forEach(tag -> System.out.println(tag.getTitle()));
    }


}
