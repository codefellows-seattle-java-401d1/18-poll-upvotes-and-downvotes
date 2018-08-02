package main.Controllers;

import main.model.Questions;
import main.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/crew")
public class QuestionController {
    @Autowired
    QuestionRepository QuestionRepository;

    @RequestMapping("/")
    @ResponseBody
    public List<Questions> getAll() {
        List<Questions> question = QuestionRepository.findAll();
        Collections.sort(question);
        return question;
    }

    @PostMapping("/")
    @ResponseBody
    public Questions create(
         @RequestParam String question
    ) {
        Questions question = new Questions(question, 0, 0);
        question = QuestionRepository.save(question);
        return question;
    }

    @GetMapping("/{id}/upvote")
    public String upvote(
            @PathVariable("id") long id
    ) {
        Optional optional = QuestionRepository.findById(id);
        Questions question = (Questions) optional.get();
        if (question != null) {
            question.upvotes++;
            question.downvotes++;
            QuestionRepository.save(question);
        }
        return "redirect:/";
    }
}
