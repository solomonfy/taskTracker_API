package com.solomon.taskTracker;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter {

}
