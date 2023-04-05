package com.example.todolist.member.service;

import com.example.todolist.member.dto.MemberDto;
import com.example.todolist.member.entity.Member;
import com.example.todolist.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public MemberDto save(String name) {
        Member member = Member.builder().name(name).build();
        Member saveMember = memberRepository.save(member);
        return modelMapper.map(saveMember, MemberDto.class);
    }

}
