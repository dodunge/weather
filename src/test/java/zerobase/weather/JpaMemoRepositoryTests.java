package zerobase.weather;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@Slf4j
public class JpaMemoRepositoryTests {
    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void saveTest() {
        //given
        Memo newMemo = new Memo(10, "this is jpa memo!");

        //when
        jpaMemoRepository.save(newMemo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        //given
        // java처리 부분에서 id컬럼 부분에 무슨 수를 넣어서 insert해도,
        // mysql에 autoIncrement로 작성된 id값이 등록된다.
        Memo newMemo = new Memo(11, "jpa");
        //when
        Memo memo = jpaMemoRepository.save(newMemo);
        System.out.println(memo.getId());
        //then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals("jpa", result.get().getText());
    }
}
