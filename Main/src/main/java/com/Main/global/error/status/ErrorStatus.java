package com.Main.global.error.status;

import com.Main.global.error.code.BaseErrorCode;
import com.Main.global.error.dto.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    //기본(전역) 에러
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON_500", "서버에서 요청을 처리 하는 동안 오류가 발생했습니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON_400", "입력 값이 잘못된 요청 입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON_401", "인증이 필요 합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "금지된 요청 입니다."),

    //User 관련 에러
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_001", "사용자를 찾을 수 없습니다."),

    //Matches 관련 에러
    MATCHES_NOT_FOUND(HttpStatus.NOT_FOUND, "MATCHES_001", "매치를 찾을 수 없습니다."),
    PLACE_NOT_FOUND(HttpStatus.NOT_FOUND, "PLACE_001", "구장을 찾을 수 없습니다."),

    INVALID_TEAMTYPE(HttpStatus.NOT_FOUND, "TEAMTYPE_001", "팀 종류를 찾을 수 없습니다."),


    //Block 관련 에러
    BLOCK_NOT_FOUND(HttpStatus.NOT_FOUND, "BLOCK_001", "차단이 존재하지 않습니다. "),
    ALREADY_BLOCK_EXIST(HttpStatus.CONFLICT, "BLOCK_002", "이미 차단한 유저입니다."),

    //Favorite 관련 에러
    FAVORITE_NOT_FOUND(HttpStatus.NOT_FOUND, "FAVORITE_001", "즐겨찾기를 찾을 수 없습니다. "),
    ALREADY_FAVORITE_EXIST(HttpStatus.CONFLICT, "FAVORITE_002", "이미 존재하는 즐겨찾기입니다."),

    //Group 관련 에러
    GROUP_NOT_FOUND(HttpStatus.NOT_FOUND,"GROUP_001","그룹을 찾을 수 없습니다."),
    ALREADY_GROUP_EXIST(HttpStatus.NOT_FOUND,"GROUP_002","같은 code를 가진 그룹이 존재한다."),

    //Member 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"MEMBER_001","멤버를 찾을 수 없습니다."),

    //Board 관련 에러
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND,"BOARD_001","게시판을 찾을 수 없습니다."),

    //Post 관련 에러
    POST_NOT_FOUND(HttpStatus.NOT_FOUND,"POST_001","게시글을 찾을 수 없습니다."),
    //PostComment 관련 에러
    POST_COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND,"POST_COMMENT_001","댓글을 찾을 수 없습니다."),

    //Category 관련 에러
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"CATEGORY_001","카테고리를 찾을 수 없습니다."),

    //ACL 관련 에러
    ACL_PERMISSION_DENIED(HttpStatus.FORBIDDEN,"ACL_001","ACL에 권한이 없습니다."),
    BOARD_ACL_NOT_FOUND(HttpStatus.NOT_FOUND,"BOARD_ACL_001","게시판 ACL을 찾을 수 없습니다."),
    POST_ACL_NOT_FOUND(HttpStatus.NOT_FOUND,"POST_ACL_001","포스트 ACL을 찾을 수 없습니다."),

    //Role 관련 에러
    ROLE_PERMISSION_DENIED(HttpStatus.FORBIDDEN,"ROLE_001","필요한 Role을 가지고 있지 않습니다."),
    //enum class
    INVALID_ROLE(HttpStatus.FORBIDDEN,"ENUM_001","유효하지 않은 Role입니다."),
    INVALID_MAJORCODE(HttpStatus.FORBIDDEN,"ENUM_002","유효하지 않은 MAJORCODE입니다."),
    INVALID_REACTION(HttpStatus.FORBIDDEN,"ENUM_003","유효하지 않은 REACTION입니다."),
    INVALID_BOARDCODE(HttpStatus.FORBIDDEN,"ENUM_004","유효하지 않은 BOARDCODE입니다."),
    INVALID_TYPE(HttpStatus.FORBIDDEN,"ENUM_005","유효하지 않은 TYPE입니다."),
    INVALID_TARGET(HttpStatus.FORBIDDEN,"ENUM_006","유효하지 않은 TARGET입니다."),
    INVALID_ORDER(HttpStatus.FORBIDDEN,"ENUM_007","유효하지 않은 ORDER입니다."),
    INVALID_ACTION(HttpStatus.FORBIDDEN,"ENUM_008","유효하지 않은 ACTION입니다."),



    //Token 관련 에러
    INVALID_TOKEN(HttpStatus.BAD_REQUEST,"TOKEN_001","토큰이 올바르지 않습니다."),

    //Body 에러
    INVALID_BODY(HttpStatus.BAD_REQUEST, "BODY_ERROR", "Body가 올바르지 않습니다.");




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }


}
