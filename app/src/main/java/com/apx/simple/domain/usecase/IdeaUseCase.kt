package com.apx.simple.domain.usecase

//data class IdeaUseCases(
//    val addIdea: AddIdea,
//    val deleteIdea: DeleteIdea,
//    val getIdeas: GetIdeas,
//    val searchIdeas: SearchIdeas
//)
//
//class AddIdea(private val repository: IdeaRepository) {
//    suspend operator fun invoke(idea: IdeaModel) {
//        repository.addIdea(idea)
//    }
//}
//
//class DeleteIdea(private val repository: IdeaRepository) {
//    suspend operator fun invoke(idea: IdeaModel) {
//        repository.deleteIdea(idea)
//    }
//}
//
//class GetIdeas(private val repository: IdeaRepository) {
//    operator fun invoke(): Flow<List<IdeaModel>> {
//        return repository.getIdeas()
//    }
//}
//
//class SearchIdeas(private val repository: IdeaRepository) {
//    operator fun invoke(query: String): Flow<List<IdeaModel>> {
//        return repository.searchIdeas(query)
//    }
//}
