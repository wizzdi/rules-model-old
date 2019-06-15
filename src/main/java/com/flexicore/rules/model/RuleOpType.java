package com.flexicore.rules.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enum describing possible types of RuleOp")
public enum RuleOpType {
    AND,OR,NOT;
}
