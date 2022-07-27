package post.spring_api_project.service;

import post.spring_api_project.domain.Memo;
import post.spring_api_project.domain.MemoRepository;
import post.spring_api_project.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 것이 있으면 생성할 때 같이 넣어달라고 spring에 요청
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional //이게 db에 꼭 저장되어야한다고 선언
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
    public boolean checkPassword(Long id,String password) throws Exception{
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일지하지 않습니다.")
        );
        return memo.getPassword().equals(password);
    }
}
