package com.shop.shop.controller;


import com.shop.shop.dto.MemberFormDto;
import com.shop.shop.dto.UpdateDto;
import com.shop.shop.entity.Member;
import com.shop.shop.repository.MemberRepository;
import com.shop.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @GetMapping(value = "/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping(value = "/new")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            return "member/memberForm";
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginMember() {

        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/members/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/newAdmin")
   public String adminMemberForm(Model model) {
       model.addAttribute("memberFormDto", new MemberFormDto());
       return "member/memberForm";
    }

    @PostMapping(value = "/newAdmin")
   public String newAdminMember(@Valid MemberFormDto memberFormDto,
                                 BindingResult bindingResult, Model model) {
       if (bindingResult.hasErrors()) {
            return "member/memberForm";
        }
        try {
            Member member = Member.createAdminMember(memberFormDto, passwordEncoder);
        } catch (IllegalStateException e) {
            model.addAttribute("errormessage", e.getMessage());
            return "member/memberForm";
      }
        return "redirect:/";
    }

    @GetMapping(value = "/loginInfo")
    public String memberInfo(Principal principal, ModelMap modelMap) {
        String loginId = principal.getName();
        Member member = memberRepository.findByEmail(loginId);
        modelMap.addAttribute("member", member);
        return "mypage/myInfo";
    }

    @GetMapping(value = "/checkPwdForm")
    public String checkPwdView(){
        return "member/pwdCheckForm";
    }


//    @GetMapping(value = "/checkPwd")
//    @ResponseBody
//    public boolean checkPassword( Principal principal,Member member,
//                                 @RequestParam String checkPassword,Model model){
//        String loginId = principal.getName();
//        Member memberId = memberRepository.findByEmail(loginId);
//        return memberService.checkPassword(memberId, checkPassword);
//    }

//
//    @GetMapping(value = "/updateForm")
//    public String updateMemberForm(Principal principal, Model model){
//        String loginId = principal.getName();
//        Member memberId = memberRepository.findByEmail(loginId);
//        model.addAttribute("member",memberId);
//
//        return "/mypage/memberUpdateForm";
//    }
//    @PostMapping(value = "/updateForm")
//    public String updateMember(@Valid UpdateDto updateDto, Model model){
//        model.addAttribute("member",updateDto);
//        memberService.updateMember(updateDto);
//        return "redirect:/mypage/memberUpdateForm";
//    }




}