package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

// DB와 연동하는 코드 작성할 때에는 Repository패키지 아래에 작성
@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {
}
