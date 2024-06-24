package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
  private final int currentPage;
  private final int pageLimit;
  private final int totalPages;
  private final long totalElements;
  

    /**
     * Creates a `PageInfo` object from a pageable and page, providing information on the
     * current page number, size, total pages, and total elements.
     * 
     * @param pageable pageable request object that contains information about the
     * pagination, such as the number of pages and elements per page.
     * 
     * @param page current page being processed, providing information on its position,
     * size, and total number of pages and elements in the result set.
     * 
     * @returns a `PageInfo` object containing page number, page size, total pages, and
     * total elements.
     */
    public static PageInfo of(Pageable pageable, Page<?> page) {
    return new PageInfo(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
