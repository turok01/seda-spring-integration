package org.example.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ChannelConfiguration {

    private final TaskExecutor receiveTextChannelThreadPool;
    private final TaskExecutor toLowerCaseChannelThreadPool;
    private final TaskExecutor splitWordsChannelThreadPool;
    private final TaskExecutor countWordsChannelThreadPool;
    private final TaskExecutor returnResponseChannelThreadPool;

    public ChannelConfiguration(TaskExecutor receiveTextChannelThreadPool, TaskExecutor toLowerCaseChannelThreadPool, TaskExecutor splitWordsChannelThreadPool, TaskExecutor countWordsChannelThreadPool, TaskExecutor returnResponseChannelThreadPool) {
        this.receiveTextChannelThreadPool = receiveTextChannelThreadPool;
        this.toLowerCaseChannelThreadPool = toLowerCaseChannelThreadPool;
        this.splitWordsChannelThreadPool = splitWordsChannelThreadPool;
        this.countWordsChannelThreadPool = countWordsChannelThreadPool;
        this.returnResponseChannelThreadPool = returnResponseChannelThreadPool;
    }

    @Bean(name = "receiveTextChannel")
    MessageChannel getReceiveTextChannel() {
        return MessageChannels.executor("receive-text", receiveTextChannelThreadPool)
                .get();
    }

    @Bean(name = "splitWordsChannel")
    MessageChannel getSplitWordsChannell() {
        return MessageChannels.executor("split-words", splitWordsChannelThreadPool)
                .get();
    }


    @Bean(name = "toLowerCaseChannel")
    public MessageChannel getToLowerCaseChannel() {
        return MessageChannels.executor("to-lower-case", toLowerCaseChannelThreadPool)
                .get();
    }

    @Bean(name = "countWordsChannel")
    public MessageChannel getCountWordsChannel() {
        return MessageChannels.executor("count-words", countWordsChannelThreadPool)
                .get();
    }

    @Bean(name = "returnResponseChannel")
    public MessageChannel getReturnResponseChannel() {
        return MessageChannels.executor("return-response", returnResponseChannelThreadPool)
                .get();
    }


}
