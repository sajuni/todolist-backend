package com.example.todolist.member.service;

import com.example.todolist.member.dto.MemberDto;
import com.example.todolist.member.entity.Member;
import com.example.todolist.member.repository.MemberRepository;
import com.example.todolist.todo.dto.TodoResDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public MemberDto getMember(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);
        if (findMember.isPresent()) {
            Member member = findMember.get();
            List<TodoResDto> todoDtoList = member.getTodoList().stream()
                    .map(todo -> modelMapper.map(todo, TodoResDto.class))
                    .collect(Collectors.toList());
            MemberDto memberDto = modelMapper.map(member, MemberDto.class);
            memberDto.setTodoList(todoDtoList);
            return memberDto;
        }
        throw new RuntimeException("TODO리스트 조회 중 오류 발생");
    }

}
