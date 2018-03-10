package com.oukingtim.web;

import com.oukingtim.domain.Advances;
import com.oukingtim.domain.CompleteTask;
import com.oukingtim.service.AdvancesService;
import com.oukingtim.service.CompleteTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haley on 10/03/2018.
 */


@RestController
@RequestMapping("/api/complete_task")
public class CompleteTaskController extends BaseController<CompleteTaskService, CompleteTask> {
}
