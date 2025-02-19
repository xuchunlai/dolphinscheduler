/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.dao.repository;

import org.apache.dolphinscheduler.dao.entity.ProcessInstance;
import org.apache.dolphinscheduler.plugin.task.api.model.DateInterval;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProcessInstanceDao {

    public int insertProcessInstance(ProcessInstance processInstance);

    public int updateProcessInstance(ProcessInstance processInstance);

    /**
     * insert or update work process instance to database
     *
     * @param processInstance processInstance
     */
    public int upsertProcessInstance(ProcessInstance processInstance);

    void deleteByIds(List<Integer> needToDeleteWorkflowInstanceIds);

    void deleteById(Integer workflowInstanceId);

    ProcessInstance queryByWorkflowInstanceId(Integer workflowInstanceId);

    /**
     * find last scheduler process instance in the date interval
     *
     * @param definitionCode definitionCode
     * @param dateInterval   dateInterval
     * @return process instance
     */
    ProcessInstance findLastSchedulerProcessInterval(Long definitionCode, DateInterval dateInterval, int testFlag);

    /**
     * find last manual process instance interval
     *
     * @param definitionCode process definition code
     * @param dateInterval   dateInterval
     * @return process instance
     */
    ProcessInstance findLastManualProcessInterval(Long definitionCode, DateInterval dateInterval, int testFlag);

    /**
     * find last running process instance
     *
     * @param definitionCode process definition code
     * @param startTime      start time
     * @param endTime        end time
     * @return process instance
     */
    ProcessInstance findLastRunningProcess(Long definitionCode, Date startTime, Date endTime, int testFlag);

    /**
     * query first schedule process instance
     *
     * @param definitionCode definitionCode
     * @return process instance
     */
    ProcessInstance queryFirstScheduleProcessInstance(@Param("processDefinitionCode") Long definitionCode);

    /**
     * query first manual process instance
     *
     * @param definitionCode definitionCode
     * @return process instance
     */
    ProcessInstance queryFirstStartProcessInstance(@Param("processDefinitionCode") Long definitionCode);
}
