package com.zcckj.esign.dto.res;

import com.zcckj.esign.dto.Administrator;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class GetAdministratorsRes implements Serializable {
    private static final long serialVersionUID = -215104115375050274L;

    private List<Administrator> administrators;
}
