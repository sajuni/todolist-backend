package com.example.todolist.member.service;

import com.example.todolist.member.dto.MemberDto;
import com.example.todolist.member.entity.Member;
import com.example.todolist.member.repository.MemberRepository;
import com.example.todolist.todo.dto.TodoResDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public MemberDto save(String name) {
        long count = memberRepository.count();
        if (count < 8) {
            Member member = Member.builder().name(name).build();
            Member saveMember = memberRepository.save(member);
            return modelMapper.map(saveMember, MemberDto.class);
        } else {
            throw new RuntimeException("8명 이상 등록 할 수 없습니다.");
        }
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

    public List<MemberDto> getAllMember() {
        List<Member> all = memberRepository.findAllTodoList();
        Type listType = new TypeToken<List<MemberDto>>() {}.getType();
        return modelMapper.map(all, listType);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}
