package com.shop.shop.entity;

import com.shop.shop.constant.Role;
import com.shop.shop.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
@Builder
@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity{

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String zipCode;
    private String streetAddress;
    private String detailAddress;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String rawPassword;



    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        return createMember(memberFormDto, passwordEncoder, Role.USER);
    }

    public static Member createAdminMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        return createMember(memberFormDto, passwordEncoder, Role.ADMIN);
    }

    private static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder, Role role) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());

        member.setZipCode(memberFormDto.getZipCode());
        member.setDetailAddress(memberFormDto.getDetailAdr());
        member.setStreetAddress(memberFormDto.getStreetAdr());

        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(role);
        return member;
    }


    public void updateUsername(String name) {
        this.name = name;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    public void updateZipcode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void updateStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void updateDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }


}



