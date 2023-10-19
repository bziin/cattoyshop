package com.shop.shop.controller;

import com.shop.shop.dto.UpdateDto;
import com.shop.shop.entity.Member;
import com.shop.shop.repository.MemberRepository;
import com.shop.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.SysexMessage;
import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/rest")
@Controller
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @GetMapping(value = "/checkPwdForm")
    @ResponseBody
    public boolean checkPassword(@RequestParam String checkPassword, Principal principal) {
        String loginId = principal.getName();
        Member memberId = memberRepository.findByEmail(loginId);
        System.out.println(memberId.getPassword());
        return memberService.checkPassword(memberId,checkPassword);
    }

    @GetMapping(value = "/updateForm")
    public String updateMemberForm(Principal principal, Model model) {
        String loginId = principal.getName();
        Member member = memberRepository.findByEmail(loginId);
        UpdateDto updateDto = new UpdateDto();
        updateDto.setEmail(member.getEmail());
        updateDto.setName(member.getName());
        updateDto.setZipCode(member.getZipCode());
        updateDto.setStreetAddress(member.getStreetAddress());
        updateDto.setDetailAddress(member.getDetailAddress());

        model.addAttribute("updateDto", updateDto);
        return "mypage/memberUpdateForm";
    }

    @PostMapping(value = "/updateForm")
    public String updateMember(@Valid UpdateDto updateDto, Model model) {
        model.addAttribute("member", updateDto);
        memberService.updateMember(updateDto);
        return "redirect:/members/loginInfo";
    }
}


