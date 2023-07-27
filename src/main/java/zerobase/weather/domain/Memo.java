package zerobase.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "memo")
public class Memo {
    @Id
    // GenerationType.IDENTITY : spring boot에서는 key생성을 하지 않고,
    // mysql한테 데이터를 넣어보고 만들어준 key 값이 있으면 그 값을 가져오는
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
}
