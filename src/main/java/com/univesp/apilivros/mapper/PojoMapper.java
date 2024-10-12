package com.univesp.apilivros.mapper;

import com.univesp.apilivros.model.Aluno;
import com.univesp.apilivros.model.Livro;
import com.univesp.apilivros.model.dto.AlunoDto;
import com.univesp.apilivros.model.dto.LivroDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PojoMapper {
    Aluno alunoDtoToEntity(AlunoDto dto);
    AlunoDto alunoEntityToDto(Aluno entity);
    Livro livroDtoToEntity(LivroDto dto);
    LivroDto livroEntityToDto(Livro entity);
}
