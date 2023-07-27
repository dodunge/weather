package zerobase.weather;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
// test코드에 의해서 DB의 D가 변경되는 것을 막기 위해 작성
// 테스트가 완료된 후에 다 롤백됨.
@Transactional
@Slf4j
public class JdbcMemoRepositoryTests {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void saveTest() {
        //given
        Memo newMemo = new Memo(2, "this is second memo test~");

        //when
        jdbcMemoRepository.save(newMemo);

        //then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals("this is second memo test~", result.get().getText());
    }

    @Test
    void findAllTest() {
        //given
        //when
        List<Memo> memoList = jdbcMemoRepository.findAll();
        log.info(String.valueOf(memoList));
        //then
        assertNotNull(memoList);
    }
}
