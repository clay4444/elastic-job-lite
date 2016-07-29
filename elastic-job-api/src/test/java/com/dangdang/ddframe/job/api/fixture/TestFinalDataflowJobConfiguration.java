/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.api.fixture;

import com.dangdang.ddframe.job.api.JobConfiguration;
import com.dangdang.ddframe.job.api.JobCoreConfiguration;
import com.dangdang.ddframe.job.api.internal.config.FinalJobConfiguration;
import com.dangdang.ddframe.job.api.type.ElasticJobAssert;
import com.dangdang.ddframe.job.api.type.dataflow.api.DataflowJobConfiguration;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class TestFinalDataflowJobConfiguration implements FinalJobConfiguration {
    
    private final DataflowJobConfiguration.DataflowType dataflowType;
    
    private final boolean streamingProcess;
    
    private final int concurrentDataProcessThreadCount;
    
    @Override
    public JobConfiguration getJobConfig() {
        return new DataflowJobConfiguration(
                JobCoreConfiguration.newBuilder(ElasticJobAssert.JOB_NAME, "0/1 * * * * * ?", 10).build(), TestDataflowJob.class, dataflowType, streamingProcess, concurrentDataProcessThreadCount); 
    }
}
