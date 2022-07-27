package post.spring_api_project.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end); // JPA findAll  전부 찾고 수정된 날싸순으로 내림차순 정렬해줘 Timestamped에서의 두가지 필드 createAt과 modifiedAt  그래서 modifiedAt을 사용할 수있다.
}
