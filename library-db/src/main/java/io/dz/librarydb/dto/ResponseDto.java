package io.dz.librarydb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto<T>  implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseDto.class);
    @JsonIgnore
    private static final long serialVersionUID = 1L;
    private List<T> data = new ArrayList();
    private String nextLink;
    private int count;

    public String toString() {
        return "{ data= " + this.data + " ,\n" + "nextLink = " + this.nextLink + " ,\n" + "count = " + this.count + "}";
    }
}
