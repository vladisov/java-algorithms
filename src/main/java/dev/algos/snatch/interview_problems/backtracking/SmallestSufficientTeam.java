package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * In a project, you have a list of required skills req_skills, and a list of people.  The i-th person people[i] contains a list of skills that person has.
 * Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill.  We can represent these teams by the index of each person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 * Return any sufficient team of the smallest possible size, represented by the index of each person.
 * You may return the answer in any order.  It is guaranteed an answer exists.
 * <p>
 * Example 1:
 * <p>
 * Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * Output: [0,2]
 * Example 2:
 * <p>
 * Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * Output: [1,2]
 */
public class SmallestSufficientTeam {


    /**
     * Non optimal backtracking
     * Time O(people^skills)
     * Space O(skills) recursion stack
     */
    public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            List<String> list = people.get(i);
            for (String skill : list) {
                map.putIfAbsent(skill, new ArrayList<>());
                map.get(skill).add(i);
            }
        }
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            skillIndex.put(skills[i], i);
        }
        var result = helper(skills, 0, map, people, new Stack<>(), 0, skillIndex);
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private List<Integer> helper(String[] skills, int index, Map<String, List<Integer>> map, List<List<String>> people, Stack<Integer> visitedPeople,
                                 int visitedSkills, Map<String, Integer> skillIndex) {
        if (index == skills.length) {
            return new ArrayList<>(visitedPeople);
        }
        var skill = skills[index];
        if (hasSkill(visitedSkills, skill, skillIndex)) {
            return helper(skills, index + 1, map, people, visitedPeople, visitedSkills, skillIndex);
        } else {
            var peopleBySkill = map.get(skill);
            List<Integer> result = null;
            for (int person : peopleBySkill) {
                visitedPeople.add(person);
                int tmp = visitedSkills;
                visitedSkills = markSkillsVisited(person, people, visitedSkills, skillIndex);
                List<Integer> peopleList = helper(skills, index + 1, map, people, visitedPeople, visitedSkills, skillIndex);
                if (result == null || peopleList.size() < result.size()) {
                    result = peopleList;
                }
                visitedSkills = tmp;
                visitedPeople.pop();
            }
            return result;
        }
    }

    private boolean hasSkill(int visitedSkills, String skill, Map<String, Integer> skillIndex) {
        int index = skillIndex.get(skill);
        return ((visitedSkills & (1 << index)) != 0);
    }

    private int markSkillsVisited(int person, List<List<String>> people, int visitedSkills, Map<String, Integer> skillIndex) {
        List<String> skillsByPerson = people.get(person);
        for (String skillByPerson : skillsByPerson) {
            int index = skillIndex.get(skillByPerson);
            visitedSkills |= (1 << index);
        }
        return visitedSkills;
    }
}
