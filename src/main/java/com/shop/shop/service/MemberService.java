package com.shop.shop.service;

import com.shop.shop.config.SecurityConfig;
import com.shop.shop.dto.UpdateDto;
import com.shop.shop.entity.Member;
import com.shop.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
@RequiredArgsConstructor



public class MemberService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder; // PasswordEncoder를 주입받음

    private final MemberRepository memberRepository;

@Transactional
    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

    @ResponseBody
    public boolean checkPassword(Member member, String checkPassword) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember == null) {
            throw new IllegalArgumentException("해당 이메일로 가입된 회원이 없습니다.");
        }
        String rawPassword = member.getPassword();
        boolean matches = passwordEncoder.matches(checkPassword,rawPassword);
        System.out.println(matches);
        return matches;
    }

    public Long updateMember(UpdateDto updateDto){
    Member member= memberRepository.findByEmail(updateDto.getEmail());
    member.updateUsername(updateDto.getName());
    member.updateZipcode(updateDto.getZipCode());
    member.updateDetailAddress(updateDto.getDetailAddress());
    member.updateStreetAddress(updateDto.getStreetAddress());
    member.updateRawPassword(updateDto.getPassword());

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodePw = encoder.encode(updateDto.getPassword());
    member.updatePassword(encodePw);
    memberRepository.save(member);

    return member.getId();
    }
}




