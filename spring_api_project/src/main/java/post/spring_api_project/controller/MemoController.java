package post.spring_api_project.controller;

import post.spring_api_project.domain.Memo;
import post.spring_api_project.domain.MemoRepository;
import post.spring_api_project.domain.MemoRequestDto;
import post.spring_api_project.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class MemoController {

    //필수적인 것들
    private final MemoRepository memoRepository;
    //필수적인 것들
    private final MemoService memoService;

    @PostMapping("/api/post")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @PostMapping("/api/post/{id}")
    public boolean checkPassword(@PathVariable Long id , @RequestBody MemoRequestDto requestDto) throws Exception{
        return memoService.checkPassword(id,requestDto.getPassword());
    }

    @GetMapping("/api/post")
    public List<Memo> getMemos() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }
    @GetMapping("/api/post/{id}")
    public Optional<Memo> getMyMemos(@PathVariable Long id){
        return memoRepository.findById(id);

    }

    @PutMapping("/api/post/{id}")
    public Optional<Memo> updateMemos(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        memoService.update(id , requestDto);
        Optional<Memo> memo = memoRepository.findById(id);
        return memo;
    }
    @DeleteMapping("/api/post/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}

