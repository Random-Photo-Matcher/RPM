package com.rpm.rpm.sending;

import com.rpm.rpm.ImgStorage;
import com.rpm.rpm.Location;
import com.rpm.rpm.matching.Matching;
import com.rpm.rpm.matching.MatchingRepository;
import com.rpm.rpm.users.Users;
import com.rpm.rpm.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) // 혹여나 사태에 대비해 readOnly를 걸어놓고, transaction이 필요할 때 메서드 위에 @Transactional 어노테이션을 추가한다.
@RequiredArgsConstructor
public class SendingService {
    private final SendingRepository sendingRepository;
    private final UsersRepository usersRepository;
    private final MatchingRepository matchingRepository;
    private final ImgStorage imgStorage;

    /**
     * Sending이 처음 들어오게 되면 해당 메서드를 통해서 Sending 테이블에 데이터가 저장됨.
     */
    @Transactional
    public Long postSending(String userId, Location location, MultipartFile image){
        // 1. 유저를 찾는다.
        Users users = usersRepository.findByLoginId(userId);

        // 2. 사진을 저장한다.
        String imgUrl = imgStorage.save(image);

        // 3. sending 엔티티 생성
        Sending sending = Sending.builder()
                            .user(users)
                            .location(location)
                            .imgUrl(imgUrl)
                            .build();

        // 4. sending 엔티티 저장
        Sending savedSending = sendingRepository.save(sending);

        // 5. 쿼리를 즉시 날려줌. (6의 이유로, 방금 저장된 데이터가 DB에 존재해야하기 때문이다.
        sendingRepository.flush();

        // 6. Sending DB를 확인해서 Matching 시킬 데이터가 있다면 Matching 시켜준다.
        Matching savedMatching = matchingAlgorithm().orElse(null); // 아직은 필요없으니 비어있을 때 null이어도 상관 없겠지..?

        // 7. sending의 쿼리를 날려줌.
        return savedSending.getId();
    }

    /**
     * Sending DB에 있는 데이터 중 매칭 시켜줄 데이터가 있다면 매칭 시켜주는 메서드
     */
    private Optional<Matching> matchingAlgorithm() {
        if(canMatch()){
            return Optional.of(startMatching());
        }

        return Optional.empty();
    }

    /**
     * Matching 행위를 시작
     */
    private Matching startMatching() {
        // 1. Mathcing 후보를 찾는다.
        List<Sending> sendings = findMatchCandidate();

        // 2. Matching 엔티티를 생성하여 넣어준다.
        Matching matching = new Matching(sendings);

        // 3. Matching을 저장한다.
        return matchingRepository.save(matching);
    }

    /**
     * Matching할 2개의 Sending을 보낸다.
     */
    private List<Sending> findMatchCandidate() {
        return null;
    }

    /**
     * 매칭할 데이터가 있는지 확인
     */
    private boolean canMatch() {
        return false;
    }
}
